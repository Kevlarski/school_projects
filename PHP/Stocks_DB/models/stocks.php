<?php

function list_stocks() {
    global $database;

    $query = 'SELECT symbol, stk_name, current_price, id FROM Stocks';
    $statement = $database->prepare($query);
    $statement->execute();
    $stocks = $statement->fetchAll();
    $statement->closeCursor();
    return $stocks;
}

function insert_stock($symbol, $stk_name, $current_price) {
    global $database;
    
    $stk_query = "INSERT INTO Stocks (symbol, stk_name, current_price) "
            . "VALUES (:symbol, :stk_name, :current_price)";
    $statement = $database->prepare($stk_query);
    $statement->bindValue(":symbol", strtoupper($symbol));
    $statement->bindValue(":stk_name", $stk_name);
    $statement->bindValue(":current_price", $current_price);
    $statement->execute();
    $statement->closeCursor();
}

function update_stock($symbol, $stk_name, $current_price) {
    global $database;
    
    $stk_query = "UPDATE Stocks set name=:stk_name, current_price=:current_price "
            . " WHERE :symbol=symbol";
    $statement = $database->prepare($stk_query);
    $statement->bindValue(":symbol", $symbol);
    $statement->bindValue(":stk_name", $stk_name);
    $statement->bindValue(":current_price", $current_price);
    $statement->execute();
    $statement->closeCursor();
}

function delete_stock($symbol) {
    global $database;
    
    $stk_query = "DELETE FROM Stocks"
            . " WHERE :symbol=symbol";
    $statement = $database->prepare($stk_query);
    $statement->bindValue(":symbol", $symbol);
    $statement->execute();
    $statement->closeCursor();
}

