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
        <!--Transactions Table--> 
        <table border="2px">
            <caption style="caption-side:top"><h3>Transactions</h3 ></caption>
            <tr>
                <th>User ID</th>
                <th>Stock ID</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>ID</th>
            </tr>
            <?php foreach ($transactions as $transaction) : ?> 
                <tr>
                    <td><?php echo $transaction['user_id'] ?></td>
                    <td><?php echo $transaction['stock_id'] ?></td>
                    <td><?php echo $transaction['quantity'] ?></td>
                    <td><?php echo "$". number_format($transaction['price'],4) ?></td>
                    <td><?php echo $transaction['id'] ?></td>
                </tr>
            <?php endforeach; ?>
        </table>
        <br/>
        <!-- Transaction Form -->
        <h3>&emsp;New Transaction</h3>
        <hr width="75%"/>
        <form action="transactions.php" method="post"> </br></br>
            <label>User Email: </label> 
            <input type="text" name="email_address"/>
            <label>&emsp;Symbol: </label> 
            <input type="text" name="symbol"/>
            <label>&emsp;Quantity: </label> 
            <input type="text" name="quantity"/>
            <input type="hidden" name="action" value="add">
            <label>&emsp;</label>
            <input type="submit" value="Finalize Transaction"/> </br></br>
        </form>

        <h3>&emsp;Update Transaction</h3>
        <hr width="75%"/>
        <form action="transactions.php" method="post"> </br></br>
            <label>&emsp;Transaction ID:</label>
            <input type="text" name="trs_id"/></br></br>
            <label>User ID: </label> 
            <input type="text" name="user_id"/>
            <label>&emsp;Stock ID: </label> 
            <input type="text" name="stock_id"/>
            <label>&emsp;Quantity: </label> 
            <input type="text" name="quantity"/>
            <label>&emsp;Price:</label>
            <input type="text" name="price"/>
            <input type="hidden" name="action" value="update">
            <label>&emsp;</label>
            <input type="submit" value="Update Transaction"/> </br></br>
        </form>

        <h3>&emsp;Delete Transaction</h3>
        <hr width="75%"/>
        <form action="transactions.php" method="post"> </br></br>
            <label>Transaction ID: </label> 
            <input type="text" name="trs_id"/>
            <input type="hidden" name="action" value="delete"><label>&emsp;</label>
            <input type="submit" value="Delete Transaction"/> </br></br>
        </form>
    </body>
</html>