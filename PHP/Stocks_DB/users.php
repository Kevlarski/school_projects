<?php
try{
    require_once 'models/database.php';
    require_once 'models/users.php';
    
    
    //user variables
    $name = htmlspecialchars(filter_input(INPUT_POST, "name"));
    $email = htmlspecialchars(filter_input(INPUT_POST, "email_address", FILTER_VALIDATE_EMAIL));
    $new_email = htmlspecialchars(filter_input(INPUT_POST, "new_email", FILTER_VALIDATE_EMAIL));
    $balance = filter_input(INPUT_POST, "cash_balance", FILTER_VALIDATE_FLOAT);
    $new_balance = filter_input(INPUT_POST, "new_balance", FILTER_VALIDATE_FLOAT);
    $usr_action = htmlspecialchars(filter_input(INPUT_POST, "usr_action"));
    
    //Users Action
    if ($usr_action == "add" && $email != "" && $name != "" && $balance != 0) {
        insert_user($name, $email, $balance);
        header("Location: users.php");
    } else if ($usr_action == "email" && $email != "" && $name != "" && $new_email != "") {
        update_user($email, $new_email);
        header("Location: users.php");
    }else if($usr_action == "balance" && $email != "" && $new_balance != "") {
        update_balance($email, $new_balance);
        header("Location: users.php");
    } else if ($usr_action == "delete" && $email != "") {
        delete_user($email);
        header("Location: users.php");
    }
    
    $users = list_users();
    include ('views/users.php');
} catch (Exception $ex) {
    $error_message = $e->getMessage();
    include ('views/errors.php');
}