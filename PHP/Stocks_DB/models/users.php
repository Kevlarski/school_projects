<?php

function list_users() {
    global $database;
    $usr_query = 'Select name, email_address, cash_balance, id FROM users';
    $usr_statement = $database->prepare($usr_query);
    $usr_statement->execute();
    $users = $usr_statement->fetchAll();
    $usr_statement->closeCursor();

    return $users;
}

function insert_user($name, $email, $balance) {
    global $database;
    $usr_query = "INSERT INTO users (name, email_address, cash_balance) "
            . " VALUES (:name, :email, :balance)";
    $usr_statement = $database->prepare($usr_query);
    $usr_statement->bindValue(":name", $name);
    $usr_statement->bindValue(":email", $email);
    $usr_statement->bindValue(":balance", $balance);

    $usr_statement->execute();
    $usr_statement->closeCursor();
}

function update_user($email, $new_email) {
    global $database;
    $usr_query = "UPDATE users set email_address=:new_email "
            . " WHERE :email=email_address";
    $statement = $database->prepare($usr_query);
    $statement->bindValue(":email", $email);
    $statement->bindValue(":new_email", $new_email);

    $statement->execute();
    $statement->closeCursor();
}

function delete_user($email) {
    global $database;
    $usr_query = "DELETE FROM users"
            . " WHERE :email=email_address";
    $statement = $database->prepare($usr_query);
    $statement->bindValue(":email", $email);

    $statement->execute();
    $statement->closeCursor();
}

function update_balance($email, $new_balance) {
    global $database;
    $usr_query = "UPDATE users SET cash_balance=:new_balance "
            . " WHERE :email=email_address";
    $statement = $database->prepare($usr_query);
    $statement->bindValue(":email", $email);
    $statement->bindValue(":new_balance", $new_balance);
    $statement->execute();
    $statement->closeCursor();
}