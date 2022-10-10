<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>DB Happy Fun Times</title>
        <style>
            table{border-collapse: collapse;}
            th,td{padding:3px;}
            hr{float:left;}
            h3{margin-bottom: 5px;}
            a{font-weight: bold;
        text-decoration: none;}

        </style>
    </head>
    <body>
        
        <?php include ('topNav.php'); ?>
        <br/>
        <!-- Users Table -->
        <table border="2px">
            <caption style="caption-side:top"><h3>Users</h3></caption>
            <tr>
                <th>User Name</th>
                <th>Email</th>
                <th>Balance</th>
                <th>ID</th>
            </tr>
            <?php foreach ($users as $user) : ?> 
                <tr>
                    <td><?php echo $user['name'] ?></td>
                    <td><?php echo $user['email_address'] ?></td>
                    <td><?php echo "$".number_format($user['cash_balance'],2) ?></td>
                    <td><?php echo $user['id'] ?></td>
                </tr>
            <?php endforeach; ?>
        </table>
        <!-- User Change Form -->
        <br/>
        <h3>&emsp;Add User</h3>
        <hr width="75%"/>
        <form action="users.php" method="post"> </br></br>
            <label>User Name: </label> 
            <input type="text" name="name"/>
            <label>&emsp;Email: </label> 
            <input type="text" name="email_address"/>
            <label>&emsp;Current Balance: </label> 
            <input type="text" name="cash_balance"/>
            <input type="hidden" name="usr_action" value="add"><label>&emsp;</label>
            <input type="submit" value="Add User"/> </br></br>
        </form>

        <h3>&emsp;Update User Email</h3>
        <hr width="75%"/>
        <form action="users.php" method="post"> </br></br>
            <label>User Name: </label> 
            <input type="text" name="name"/>
            <label>&emsp;Current Email: </label> 
            <input type="text" name="email_address"/>
            <label>&emsp;New Email:</label>
            <input type="text" name="new_email"/>
            <input type="hidden" name="usr_action" value="email"><label>&emsp;</label>
            <input type="submit" value="Update Email"/> </br></br>
        </form>
        
        <h3>&emsp;Update User Balance</h3>
        <hr width="75%"/>
        <form action="users.php" method="post"> </br></br>
            <label>User Email: </label> 
            <input type="text" name="email_address"/>
            <label>&emsp;New Balance:</label>
            <input type="text" name="new_balance"/>
            <input type="hidden" name="usr_action" value="balance"><label>&emsp;</label>
            <input type="submit" value="Update Balance"/> </br></br>
        </form>
        
        <h3>&emsp;Delete User</h3>
        <hr width="75%"/>
        <form action="users.php" method="post"> </br></br>
            <label>Email: </label> 
            <input type="text" name="email_address"/>
            <input type="hidden" name="usr_action" value="delete"><label>&emsp;</label>
            <input type="submit" value="Submit"/> </br></br>
        </form>
    </body>
</html>