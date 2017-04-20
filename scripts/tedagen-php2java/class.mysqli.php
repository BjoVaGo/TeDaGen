<?php
/**********************************************************************************************************

	MySQLi Class
	php.net/manual/en/book.mysqli.php
	php.net/manual/en/mysqli.summary.php
	
	Author: Kenny Janssens <kfrjanssens@gmail.com>
	Version: 0.3 - 16/04/2015

**********************************************************************************************************/

class db extends mysqli {
	/*
		Variables
	*/
	var $index;
	var $detailErrors;

	/*
		Constructor
	*/
    public function __construct( $credentials = "", $detailErrors = true) {
		
		// What error level do we use? (DEV or PROD env!?)
		$this->detailErrors = $detailErrors;
		
		// Verify credentials
		if( !is_array($credentials) || count($credentials) < 4 ){
			$this->showError("You need to provide correct database credentials, use this format:<br><br>array(\"host\" => \"localhost\", \"user\" => \"root\", \"pass\" => \"\", \"database\" => \"database\")");
		}
		
		// Make connection in the parent constructor
        @parent::__construct($credentials[host],$credentials[user],$credentials[pass],$credentials[database]);

		// Show connection error
        if (mysqli_connect_error()) {
            $this->showError("Connection Error: " . mysqli_connect_errno() . ' ' . mysqli_connect_error() );
        }
		/* change character set to utf8 */
		if (!mysqli::set_charset("utf8")) {
			$this->showError("Error loading character set utf8: " . mysqli::error);
		}
		
    }

	
	/*
		Execute a sequal query
	*/
	public function qry( $qry ){
		// Verify the query
		if( empty($qry) ){
			$this->showError("The query was empty.");
		}
		//$result = mysqli::query( mysqli::real_escape_string($qry) ); // Sanitized input
		$result = mysqli::query( $qry ); // Sanitized input
		if($result == false){
			$this->showError( $this->error . "<p>QUERY: <strong>".$qry."</strong></p>" );
		}
		if( $result->num_rows > 0 ){
			// Get result set
			$data = array();
			while( $row = $result->fetch_assoc() ){
				if( isset($this->index) ){
					$data[$row[$this->index]] = $row;
				}else{
					$data[] = $row;
				}
			}
		}else{
			$data = array(); // return an empty array rather that a false!
		}
		//$result->free_result;
		mysqli_free_result($result);
		$this->clearIndex();
		return $data;
	}

	/*
		sanitize input
	*/
	function safe( $message ){
		return mysqli::real_escape_string($message);
	}
	
	/*
		Exception handling
	*/
	private function showError($content){
		$out = array();
		$out[] = "<div style=\"border: 3px solid #5F9729; background-color:transparant; position:absolute; top:10px; left:10px; margin:20px; padding:64px;\">";
		$out[] = "<strong>Oops... something is going wrong!</strong>";
		if($this->detailErrors == true){
			$out[] = "<div style=\"border: 1px solid #5F9729; background:#FFFFFF;padding:8px;margin:8px;\"><code>".$content."</code></div>";
		} else {
			//$out[] = "<p>Please come back later when we squashed the bugs crawling around in our servers...<p>";
			$out[] = '<meta http-equiv="refresh" content="0; url=/404.html">';
			/* TODO: Log all Issues (on file system?)! */
		}
		$out[] = "</div>";
		echo implode("",$out);
		exit; // Stop code execution!
	}
	
	/*
		Set the index as Key of the result array
	*/
	public function setIndex($index){
		$this->index = $index;
	}

	/*
		Unset the index after any query
	*/
	private function clearIndex(){
		unset($this->index);
	}
	
	/*
		Close any open connections
	*/
	function close(){
		$mysqli->close();
	}
	
	/*
		get last insert key id
	*/
	function getInsertId(){
		return $this->insert_id;
	}
	
}

?>