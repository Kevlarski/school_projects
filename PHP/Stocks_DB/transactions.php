<?php

try {
    require_once 'models/database.php';
    require_once 'models/transactions.php';

    //transactions variables
    $user_id = filter_input(INPUT_POST, "user_id", FILTER_VALIDATE_INT);
    $action = filter_input(INPUT_POST, "action");
    $trs_id = filter_input(INPUT_POST, "trs_id", FILTER_VALIDATE_INT);
    $stock_id = filter_input(INPUT_POST, "stock_id", FILTER_VALIDATE_INT);
    $price = filter_input(INPUT_POST, "price", FILTER_VALIDATE_FLOAT);
    $quantity = (float) filter_input(INPUT_POST, "quantity", FILTER_VALIDATE_FLOAT);
    $email = filter_input(INPUT_POST, "email_address", FILTER_VALIDATE_EMAIL);
    $symbol = filter_input(INPUT_POST, "symbol");

    //Transaction Actions
    if ($action == "add" && $email != "" && $symbol != "" && $quantity != "") {
        insert_transaction($email, $symbol, $quantity);
        header("Location: transactions.php");
    } else if ($action == "update" && $trs_id != "" && $user_id != "" && $stock_id != "" && $quantity != "" && $price != 0) {
        update_transaction($trs_id, $user_id, $stock_id, $quantity, $price);
        header("Location: transactions.php");
    } else if ($action == "delete" && $trs_id != "") {
        delete_transaction($trs_id);
        header("Location: transactions.php");
    }

    $transactions = list_transactions();
    include ('views/transactions.php');
} catch (Exception $ex) {
    $error_message = $ex->getMessage();
    include ('views/errors.php');
}
