<?php
$data_source_name = 'mysql:host=localhost;dbname=Stock';
$username = 'stockuser';
$password = 'test';
$database = new PDO($data_source_name, $username, $password);
