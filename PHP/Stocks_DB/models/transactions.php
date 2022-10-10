<?php

function list_transactions() {
    global $database;
    $trs_query = 'Select user_id, stock_id, quantity, price, id FROM transactions';
    $statement = $database->prepare($trs_query);
    $statement->execute();
    $transactions = $statement->fetchAll();
    $statement->closeCursor();
    return $transactions;
}

function insert_transaction($email, $symbol, $quantity) {
    
    global $database;
    
    //selecting price and id from Stocks using functions
    $stock_id = stock_id($symbol);
    $price = stock_price($symbol);
    $total_cost = $price * $quantity;

    //selecting balance and id from users
    $usr_balance = balance($email);
    $user_id = user_id_email($email);

    //check to see if the user has enough balance, then insert into transactions,
    //else display message
    if ($total_cost < $usr_balance) {
        
        insert($user_id, $stock_id, $quantity, $price);
        
        $adjusted_balance = (float) $usr_balance - $total_cost;
        $balance_correct_query = "UPDATE users SET cash_balance=$adjusted_balance WHERE :user_id=id";
        $balance_correct_statement = $database->prepare($balance_correct_query);
        $balance_correct_statement->bindValue(":user_id", $user_id);
        $balance_correct_statement->execute();
        $balance_correct_statement->closeCursor();
    } else {
        echo '<script>alert("Insufficient Funds")</script>';
    } //end ifelse
}

function update_transaction($trs_id, $user_id, $stock_id, $quantity, $price) {
    global $database;
    $trs_query = "UPDATE transactions SET user_id=:user_id, stock_id=:stock_id, "
            . " quantity=:quantity, price=:current_price WHERE :trs_id=id";
    $statement = $database->prepare($trs_query);
    $statement->bindValue(":trs_id", $trs_id);
    $statement->bindValue(":user_id", $user_id);
    $statement->bindValue(":stock_id", $stock_id);
    $statement->bindValue(":quantity", $quantity);
    $statement->bindValue(":current_price", $price);
    $statement->execute();
    $statement->closeCursor();
}

function delete_transaction($trs_id) {
    global $database;
    //calling functions to set variables
    $user_id = user_id($trs_id);
    $price = delete_price($trs_id);
    $quantity = delete_quantity($trs_id);
    $balance = delete_balance($user_id);

    $total_cost = (float) $price * $quantity;
    $adjusted_balance = (float) $balance + $total_cost;

    $balance_update_query = "UPDATE users SET cash_balance=$adjusted_balance WHERE $user_id=id";
    $balance_update_statement = $database->prepare($balance_update_query);
    $balance_update_statement->execute();
    $balance_update_statement->closeCursor();

    $trs_query = "DELETE FROM transactions WHERE :trs_id=id";
    $statement = $database->prepare($trs_query);
    $statement->bindValue(":trs_id", $trs_id);
    $statement->execute();
    $statement->closeCursor();
}

function user_id($trs_id) {
    global $database;
    $user_id_query = "SELECT user_id FROM transactions WHERE :trs_id=id";
    $usr_statement = $database->prepare($user_id_query);
    $usr_statement->bindValue("trs_id", $trs_id);
    $usr_statement->execute();
    $user_id = $usr_statement->fetchColumn();
    $usr_statement->closeCursor();
    return $user_id;
}

function delete_price($trs_id) {
    global $database;
    $cost_price_query = "SELECT price FROM transactions WHERE :trs_id=id";
    $cost_price_statement = $database->prepare($cost_price_query);
    $cost_price_statement->bindValue("trs_id", $trs_id);
    $cost_price_statement->execute();
    $price = $cost_price_statement->fetchColumn();
    $cost_price_statement->closeCursor();
    return $price;
}

function delete_quantity($trs_id) {
    global $database;
    $cost_qnt_query = "SELECT quantity FROM transactions WHERE :trs_id=id";
    $cost_qnt_statement = $database->prepare($cost_qnt_query);
    $cost_qnt_statement->bindValue("trs_id", $trs_id);
    $cost_qnt_statement->execute();
    $quantity = $cost_qnt_statement->fetchColumn();
    $cost_qnt_statement->closeCursor();
    return $quantity;
}

function delete_balance($user_id) {
    global $database;
    $balance_correct_query = "SELECT cash_balance FROM users WHERE $user_id=id";
    $balance_correct_statement = $database->prepare($balance_correct_query);
    $balance_correct_statement->execute();
    $balance = (float) $balance_correct_statement->fetchColumn();
    $balance_correct_statement->closeCursor();
    return $balance;
}

function stock_price($symbol) {
    global $database;
    $check_query_price = "SELECT current_price FROM Stocks WHERE :symbol=symbol";
    $check_statement_price = $database->prepare($check_query_price);
    $check_statement_price->bindValue(":symbol", $symbol);
    $check_statement_price->execute();
    $price = $check_statement_price->fetchColumn();
    $check_statement_price->closeCursor();
    return $price;
}

function stock_id($symbol) {
    global $database;
    $check_query_id = "SELECT id FROM Stocks WHERE :symbol=symbol";
    $check_statement_id = $database->prepare($check_query_id);
    $check_statement_id->bindValue(":symbol", $symbol);
    $check_statement_id->execute();
    $stock_id = (int) $check_statement_id->fetchColumn();
    $check_statement_id->closeCursor();
    return $stock_id;
}

function balance($email) {
    global $database;
    $balance_query_cash = "SELECT cash_balance FROM users WHERE :email_address=email_address";
    $balance_statement_cash = $database->prepare($balance_query_cash);
    $balance_statement_cash->bindValue(":email_address", $email);
    $balance_statement_cash->execute();
    $usr_balance = (float) $balance_statement_cash->fetchColumn();
    $balance_statement_cash->closeCursor();
    return $usr_balance;
}

function user_id_email($email) {
    global $database;
    $balance_query_id = "SELECT id FROM users WHERE :email_address=email_address";
    $balance_statement_id = $database->prepare($balance_query_id);
    $balance_statement_id->bindValue(":email_address", $email);
    $balance_statement_id->execute();
    $user_id = (int) $balance_statement_id->fetchColumn();
    $balance_statement_id->closeCursor();
    return $user_id;
}

function insert($user_id, $stock_id, $quantity, $price) {
    global $database;
    $trs_query = "INSERT INTO transactions (user_id, stock_id, quantity, price) "
            . "VALUES (:user_id, :stock_id, :quantity, :price)";
    $statement = $database->prepare($trs_query);
    $statement->bindValue(":user_id", $user_id);
    $statement->bindValue(":stock_id", $stock_id);
    $statement->bindValue(":quantity", $quantity);
    $statement->bindValue(":price", $price);
    $statement->execute();
    $statement->closeCursor();
}
