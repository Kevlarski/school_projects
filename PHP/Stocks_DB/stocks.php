<?php

try {
    require_once 'models/database.php';
    require_once 'models/stocks.php';
    

    //stocks variables
    $stk_action = htmlspecialchars(filter_input(INPUT_POST, "stk_action"));
    $symbol = htmlspecialchars(filter_input(INPUT_POST, "symbol"));
    $stk_name = htmlspecialchars(filter_input(INPUT_POST, "stk_name"));
    $current_price = filter_input(INPUT_POST, "current_price", FILTER_VALIDATE_FLOAT);

    //Stocks Action
    if ($stk_action == "add" && $symbol != "" && $stk_name != "" && $current_price != 0) {
        insert_stock($symbol, $stk_name, $current_price);
        header("Location: stocks.php");
        
    } else if ($stk_action == "update" && $symbol != "" && $stk_name != "" && $current_price != 0) {
        update_stock($symbol, $stk_name, $current_price);
        header("Location: stocks.php");
        
    } else if ($stk_action == "delete" && $symbol != "") {
        delete_stock($symbol);
        header("Location: stocks.php");
    }
    
    $stocks = list_stocks();
    include ('views/stocks.php');
    
} catch (Exception $e) {
    $error_message = $e->getMessage();
    include 'views/errors.php';
}
