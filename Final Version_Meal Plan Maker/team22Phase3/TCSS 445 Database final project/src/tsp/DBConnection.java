// DBConnection.java  name: DBConnection Class
// Writen by Nikolay Kravchuk.
// Date: 05/15/2014
package tsp;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Vector;


// Connection class that handels DB connection.
public class DBConnection {
	private Connection Conn ; 
	// Initialize connection 
	DBConnection( String theConnectionURL, String theUserName, String theUserPassword)
	{
		// try connect 
	      try {
	         //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	         Class.forName("com.mysql.jdbc.Driver");
	         Conn = DriverManager.getConnection(theConnectionURL, theUserName, theUserPassword);
	         // debug to console
	         System.out.println("connected");	       
	      } catch (Exception e) {
	    	  // show error
	         e.printStackTrace();
	      }
	} // end Initialization 
	
        public ArrayList<User> getUserList() {
            String accountName;
            String accountPW;
            String accountCreatedOn;
            String accountLastSignOn;
            String accountSbName;
            String accountSbAddress;
            String accountSbPhone;
            String accountSbEmail;
            ArrayList<User> userList = new ArrayList<User>();
            
            Statement statement;
		try {
                    statement = Conn.createStatement();
                    String queryString; 
                    queryString = "select * from Account";

	        ResultSet rset = statement.executeQuery(queryString);
	        while (rset.next()) {
                    accountName = rset.getString(1);
                    accountPW = rset.getString(2);
                    accountCreatedOn = rset.getString(3);
                    accountLastSignOn = rset.getString(4);
                    accountSbName = rset.getString(5);
                    accountSbAddress = rset.getString(6);
                    accountSbPhone = rset.getString(7);
                    accountSbEmail = rset.getString(8);       
                    
                    userList.add(new User(accountName, accountPW, accountCreatedOn, accountLastSignOn,
                    accountSbName, accountSbAddress, accountSbPhone, accountSbEmail));
	        }
              	
		} catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
		}
                return userList;
        }
        
        public String getMealPlan(String theAccountName){
            
            StringBuilder sb = new StringBuilder();
	    Statement statement;

		try {
                    statement = Conn.createStatement();
                    String queryString; 
                    queryString = "select Food_Name, Food_Type, Date, Account_Name from Meal_Plan "
                            + "WHERE Account_Name = '" + theAccountName + "'";

                    ResultSet rset = statement.executeQuery(queryString);
                    boolean testing = rset.next();
                    
                    if(!testing) {
                        return "";
                    } else {
                        while (testing) {
                            for(int c = 1; c < 5; c++) {
                                sb.append(rset.getString(c));
                                if(c != 4) {
                                    sb.append(", ");
                                }
                            }
                            testing = rset.next();
                            sb.append("\n");
                        }
                    }
			
		} catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
		}
		return sb.toString();
	}
        
        public boolean insertNewMeanPlan(String theData, String theFoodName,
                String theFoodType, String theAccountName){
		
            Statement statement;
            boolean insertResult = false;
            int currentID = -1;
            
            try {
                statement = Conn.createStatement();
                String queryString; 
                queryString = "SELECT Meal_Record_ID FROM Meal_Plan";
                ResultSet rset = statement.executeQuery(queryString);
                
                if(rset.next()) {
                    rset.last();
                    //Integer.toString((int)currentID + 1)
                    currentID = Integer.parseInt(rset.getString(1)) + 1;
                } else {
                    currentID = 1;
                    System.out.println("The current ID is : " + currentID);
                }
                
                statement = Conn.createStatement();
                queryString = "INSERT INTO Meal_Plan " +
                   "VALUES ('" + currentID + "', '" + theData + "' ,'"  + theFoodName
                        + "', '" + theFoodType + "', '" + theAccountName + "')";
                
                System.out.println(queryString);
                statement.executeUpdate(queryString);
                insertResult = true;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return insertResult;
	}
        
        public List<String> getAllTheFoodName () {
            Statement statement;

            List<String> results = new ArrayList<String>();
            
            try {
                String queryString;
                statement = Conn.createStatement(); 
                queryString = "SELECT Food_Name FROM Food";
                        
                ResultSet rset = statement.executeQuery(queryString);                    
                
                while(rset.next()) {
                    results.add(rset.getString(1));
                }
                
                return results;
                
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            
            return null;
        }
        
        public List<String> getAllTheFoodtpye () {
            Statement statement;
            
            List<String> results = new ArrayList<String>();
            
            try {
                String queryString;
                statement = Conn.createStatement(); 
                queryString = "SELECT Food_Type FROM Food GROUP BY Food_Type";
                        
                ResultSet rset = statement.executeQuery(queryString);                    
                while(rset.next()) {
                    results.add(rset.getString(1));
                }

                
                return results;
                
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            
            return null;
        }
        
	public boolean userExistCheck(String theUserName, String theUserPassword) {
            
            boolean isExist = false;
            Statement statement;
		
            try {
                String queryString;
                statement = Conn.createStatement(); 
                queryString = "SELECT Account_Name, Account_PW from Account "
                        + "WHERE Account_Name = '" + theUserName + "'" 
                        + "AND Account_PW = '" + theUserPassword + "'";
                ResultSet rset = statement.executeQuery(queryString);
                
                if(rset.next()) {
                    String dbAccountName = rset.getString(1);
                    //System.out.println("Account Name from the database : " + dbAccountName);
                    String dbAccountPassword = rset.getString(2);
                    //System.out.println("Account password from the database : " + dbAccountPassword);
                    
                    if(Objects.equals(theUserName, dbAccountName) 
                            && Objects.equals(theUserPassword, dbAccountPassword)) {
                        isExist = true;
                    }
                } else {
                    isExist = false;
                }
                
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            
            return isExist;
        }
	
	public boolean insertNewUser(String theAccountName, String theAccountPW,
                String theAccountSbName, String theAccountSbAddress, String theAccountSbPhone,
                String theAccountSbEmail, String theCreatedTime){
		
            boolean insertResult = false;

            try {
                PreparedStatement queryString = Conn.prepareStatement
                        ("INSERT INTO Account"
				+ "(Account_Name, Account_PW, Account_CreateOn, Account_LastSignOn,"
                                + "Account_SbName, Account_SbAddress, Account_SbPhone,"
                                + " Account_SbEmail) VALUES"
				+ "(?,?,?,?,?,?,?,?)");
                
                queryString.setString(1, theAccountName);
                queryString.setString(2, theAccountPW);
                queryString.setString(3, theCreatedTime);
                queryString.setString(4, theCreatedTime);
                queryString.setString(5, theAccountSbName);
                queryString.setString(6, theAccountSbAddress);
                queryString.setString(7, theAccountSbPhone);
                queryString.setString(8, theAccountSbEmail);
                
                int updateResult = queryString.executeUpdate();
                
                if(updateResult == 0) {
                        // number == 0, nothing change
                    System.out.println("Update fail");
                    insertResult = false;
                } else { 
                        // number > 0, something change
                    System.out.println("Update successful");
                    insertResult = true;
                }
                
                insertResult = true;
                System.out.println("Insert successful");
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }

            return insertResult;
	}
		
	//---------------------------------------------------------------
	public String listAllUser(String query){
            
            int columeNumberInAccount = 9;
	    Statement statement;
	    String result = "";
		try {
                    statement = Conn.createStatement();
                    String queryString; 
	        if (query == ""){
                    queryString = "select * from Account";
                } else {
                    queryString = query;
	        }
	        ResultSet rset = statement.executeQuery(queryString);
	        while (rset.next()) {
                    for(int c = 1; c < columeNumberInAccount; c++) {
                            result = rset.getString(c);
                            System.out.print(result + " ");
                    }
                    System.out.println();
	        }
			
		} catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
		}
		return result;
	}
	
	public boolean deleteUser(String theUserName) {
	    Statement statement;
	    boolean deleteResult = false;
		try {
                    statement = Conn.createStatement();
                    String queryString; 
                    queryString = "DELETE FROM Account WHERE Account_Name = '" + theUserName + "'";
                    //System.out.println(queryString);
                    int updateResult = statement.executeUpdate(queryString);
	        if(updateResult == 0) {
	        	// number == 0, nothing change
	        	System.out.println("Delete fail");
	        	deleteResult = false;
	        } else { 
	        	// number > 0, something change
	        	System.out.println("Delete successful");
	        	deleteResult = true;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteResult;
	}
	
	public boolean updateRecord(String theAccountName, String theAccountPW,
                String theAccountSbName, String theAccountSbAddress, String theAccountSbPhone,
                String theAccountSbEmail) {
	    
	    int updateResult = -1;
            boolean finalResult = false;
		
            try {
                
                PreparedStatement updateQuery = Conn.prepareStatement
                        ("UPDATE Account SET Account_PW = ?, "
                                + "Account_SbName = ?, "
                                + "Account_SbAddress = ?, " 
                                + "Account_SbPhone = ?, "
                                + "Account_SbEmail = ? "
                                + "WHERE Account_Name = '" + theAccountName + "'");
                
                updateQuery.setString(1, theAccountPW);
                updateQuery.setString(2, theAccountSbName);
                updateQuery.setString(3, theAccountSbAddress);
                updateQuery.setString(4, theAccountSbPhone);
                updateQuery.setString(5, theAccountSbEmail);
                
                System.out.println(updateQuery);
                
                //System.out.println("The query looks like : " + updateQuery.toString());
                
                
                updateResult = updateQuery.executeUpdate();
                
                if(updateResult == 0) {
                        // number == 0, nothing change
                    System.out.println("Update fail");
                    finalResult = false;
                } else { 
                        // number > 0, something change
                    System.out.println("Update successful");
                    finalResult = true;
                }
                
            } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
            }
            return finalResult;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	//---------------------------------------------------------------
//	// run query
//	public String SelectQuery(String query){
//	    Statement statement;
//	    String result = "";
//		try {
//			statement = Conn.createStatement();
//	        String queryString; 
//	        if (query == ""){
//	        	queryString = "select * from sysobjects where type='u'";
//	        } else {
//	        	queryString = query;
//	        }
//	        ResultSet rset = statement.executeQuery(queryString);
//	        while (rset.next()) {
//	           result = rset.getString(1);
//	        }
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	// update query
//	public int UpdateQuery(String query){
//		Statement stm;
//		int result = 0;
//		try {
//			stm = Conn.createStatement();
//			stm.executeUpdate(query); 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	 return result;
//	}
//	
//	public Product getProductDetail(int prod_id) throws SQLException
//	{
//		Statement statement = Conn.createStatement();
//		String queryString = " select p.ProductID, p.ProductCode,p.ProductName, p.Description, p.ListPrice, " +
//				" p.DiscountPercent, p.DateAdded, p.OnHand, isNull( (SELECT Reviews = " +
//				" Stuff((SELECT concat(' ; ', description) AS [text()] " +
//				" FROM  " +
//				" (SELECT  description FROM ProductReview" +
//				" where productid = p.productid" +
//				" ) x" +
//				" For XML PATH ('')),2,1,'')), '')  as reviews from products p " +
//				" where p.productid = '" + prod_id + "'";
//				//"select * from products where productId = '" + prod_id + "'";
//		ResultSet rset = statement.executeQuery(queryString);
//		while (rset.next()) {	         
//	        Product p = new Product();
//	        p.Description = rset.getString("Description");
//			p.Name = rset.getString("ProductName");		
//			p.InStock = rset.getInt("OnHand");
//			//p.Relavance = 0.2; // default value
//			p.Price = rset.getDouble("ListPrice");
//			p.ProductID = rset.getInt("ProductID");
//			// NEEDS TO DO / SPLIT THIS COMMECT AND ADD IT TO MY TABLE
//			p.UserComments = rset.getString("Reviews").split(";");
//					//new String [] { "I bought this product last year and it's still the best monitor I've had.", "After 6 months the color started going out, not sure if it was just mine or all of them" };
//			return p;
//        }
//		return null;
//	}
//	// Returns OrderDetail
//	public Order getOrderDetail(int order_id) throws SQLException
//	{	
//		Statement statement = Conn.createStatement();
//		String  queryString = "SELECT o.OrderID, " +
//				 "c.CustomerID, " +
//				 "c.FirstName + ', ' + c.LastName as Name, " +
//				 "c.emailAddress, " +
//				 "o.OrderDate, " +
//				 "(select StatusDescription from OrderStatus where StatusID = o.StatusID) as \"Status\", " +
//				 "sum((oi.ItemPrice - oi.DiscountAmount) * oi.Quantity) as TotalCost, " +
//				 "(select  CONCAT(Line1, ' ',  City, ', ', State,', ', ZipCode) from Addresses where AddressID = o.BillingAddressID) as BillingAddress, " +
//				 "(select  line2 from Addresses where AddressID = o.BillingAddressID ) as BillingInfo, " +
//				 "(select  concat(Line1, ' ', City, ', ', State, ', ', ZipCode) from Addresses where AddressID = o.ShipAddressID ) as ShippingAddress " +
//				 "FROM Customers c " +
//				 "JOIN Orders o " +
//				 "	on o.CustomerID = c.CustomerID " +
//				 "JOIN OrderItems oi " +
//				 "	on oi.OrderID = o.OrderID " +
//				 " WHERE o.orderid = '" + order_id  + "' " + 
//				 "GROUP BY o.OrderID, c.CustomerID, c.FirstName, c.LastName, c.emailaddress, o.OrderDate, o.StatusID, o.BillingAddressID, o.ShipAddressID;";
//		ResultSet rset = statement.executeQuery(queryString);
//		while (rset.next()) {	         
//			Order o = new Order();
//			o.OrderID = rset.getInt("OrderId");
//			o.Customer = new Customer();
//			o.Customer.CustomerID = rset.getInt("customerid");
//			o.Customer.Name = rset.getString("name");
//			o.Customer.Email = rset.getString("emailAddress");
//			o.OrderDate = rset.getDate("OrderDate");
//			o.Status = rset.getString("Status");
//			o.TotalCost = rset.getDouble("TotalCost");
//			o.BillingAddress = rset.getString("billingaddress");
//			o.BillingInfo	 = rset.getString("billinginfo");
//			o.ShippingAddress= rset.getString("shippingAddress");
//			o.LineItems = getLineItems(o);
//			return o;
//        }
//		return null;
//	}
//	
//// returns array of products all
//	public Product[] SelectProducts(){
//
//	 Product prod[];
//	 Vector<Product> vProduct = new Vector<Product>();
//	 
//	    Statement statement;
//		try {
//			statement = Conn.createStatement();
//
//	        String queryString;
//	        ResultSet rset;
//	        queryString = "select * from products";
//	        rset = statement.executeQuery(queryString);
//	        
//	        while (rset.next()) {	         
//		        Product p = new Product();
//				p.Description = rset.getString("Description"); //"A great monitor";
//				p.Name = rset.getString("ProductName"); //"Monitor, 19 in";
//				p.InStock = rset.getInt("OnHand"); //10;
//				p.Price = rset.getDouble("ListPrice"); // 196;
//				p.ProductID = rset.getInt("ProductID");
//				vProduct.add(p);
//	        }
//	        prod = new Product[vProduct.size()];
//	   	vProduct.toArray(prod);
//		 return prod;
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
// 
// // return Array of Customers
// public Customer[] getAllCustomers() throws SQLException{
//	 Customer custArr[];
//	 Vector<Customer> vCustomer = new Vector<Customer>();
//	 
//	 Statement statment = Conn.createStatement();
//	 String queryString;
//	 ResultSet rset;
//	 queryString = "select * from customers;";
//	 rset = statment.executeQuery(queryString);
//	 while(rset.next()){
//		 Customer c = new Customer();
//		 c.CustomerID = rset.getInt("CustomerID");
//		 c.Email = rset.getString("emailAddress");
//		 c.Name = rset.getString("firstname") +  ", " + rset.getString("LastName");
//		 vCustomer.add(c);
//	 }
//	 custArr = new Customer[vCustomer.size()];
//	 vCustomer.toArray(custArr);
//	 return custArr;	  	 
// }
// 
// // get LineItems for order
// private LineItem[] getLineItems(Order order) throws SQLException{
//	 LineItem lItem[];
//	 Vector<LineItem> vLineItem = new Vector<LineItem>();
//
//	 Statement statment = Conn.createStatement();
//	 String queryString;
//	 ResultSet rset;
//	 // new query string 
//	 queryString = "select (ItemPrice - DiscountAmount) PricePaid, " + 
//"p.Description, " + 
//"p.ProductName as Name, " +
//"p.ProductID, " +
//"oi.Quantity " + 
//" from OrderItems oi " + 
//"JOIN Products p " + 
//"on p.ProductID = oi.ProductID " + 
//"where oi.OrderID = '" + order.OrderID + "';";
//	 
//	 rset = statment.executeQuery(queryString);
//	 while(rset.next()){
//		 LineItem li = new LineItem();
//			li.Order = order;
//			li.PricePaid = rset.getDouble("PricePaid");
//			li.Product = getProductDetail(rset.getInt("ProductID")); 
//			li.Product.Description = rset.getString("Description");
//			li.Product.Name = rset.getString("Name");
//			li.Quantity = rset.getInt("Quantity");
//			vLineItem.add(li);
//	 }
//	 lItem = new LineItem[vLineItem.size()];
//	 vLineItem.toArray(lItem);
//	 return lItem;	  
// }
//
// public Order[] GetPendingOrders() throws SQLException{
//	 Order ordArr[];
//	 Vector<Order> vOrder = new Vector<Order>();
//
//	 
//	 Statement statment = Conn.createStatement();
//	 String queryString;
//	 ResultSet rset;
//	 queryString = "SELECT o.OrderID, " +
//	 "c.CustomerID, " +
//	 "c.FirstName + ', ' + c.LastName as Name, " +
//	 "c.emailAddress, " +
//	 "o.OrderDate, " +
//	 "(select StatusDescription from OrderStatus where StatusID = o.StatusID) as \"Status\", " +
//	 "sum((oi.ItemPrice - oi.DiscountAmount) * oi.Quantity) as TotalCost, " +
//	 "(select  CONCAT(Line1, ' ',  City, ', ', State,', ', ZipCode) from Addresses where AddressID = o.BillingAddressID) as BillingAddress, " +
//	 "(select  line2 from Addresses where AddressID = o.BillingAddressID ) as BillingInfo, " +
//	 "(select  concat(Line1, ' ', City, ', ', State, ', ', ZipCode) from Addresses where AddressID = o.ShipAddressID ) as ShippingAddress " +
//	 "FROM Customers c " +
//	 "JOIN Orders o " +
//	 "	on o.CustomerID = c.CustomerID " +
//	 " and o.shipDate is null " +
//	 "JOIN OrderItems oi " +
//	 "	on oi.OrderID = o.OrderID " +
//	 "GROUP BY o.OrderID, c.CustomerID, c.FirstName, c.LastName, c.emailaddress, o.OrderDate, o.StatusID, o.BillingAddressID, o.ShipAddressID;";
//	 rset = statment.executeQuery(queryString);
//	 while(rset.next()){
//		 	Order o = new Order();
//			o.OrderID = rset.getInt("OrderId");
//			o.Customer = new Customer();
//			o.Customer.CustomerID = rset.getInt("customerid");
//			o.Customer.Name = rset.getString("name");
//			o.Customer.Email = rset.getString("emailAddress");
//			o.OrderDate = rset.getDate("OrderDate");
//			o.Status = rset.getString("Status");
//			o.TotalCost = rset.getDouble("TotalCost");
//			o.BillingAddress = rset.getString("billingaddress");
//			o.BillingInfo	 = rset.getString("billinginfo");
//			o.ShippingAddress= rset.getString("shippingAddress");
//			vOrder.add(o);
//	 }
//	 ordArr = new Order[vOrder.size()];
//	 vOrder.toArray(ordArr);
//	 return ordArr;	 
// }
//
// public Product[] SearchProdReview(String searchStr ) throws SQLException{
//		 Product prodArr[];
//		 Vector<Product> vProduct = new Vector<Product>();
//		 
//		 String queryString;
//		 Statement statment = Conn.createStatement();
//		 ResultSet rset ;// = statment.executeQuery(queryString);
//		 queryString = "select pr.Description, " +
//		 		" p.ProductName as Name, " +
//		 		" p.OnHand as InStock, " +
//		 		" p.ListPrice as Price, " +
//		 		" p.ProductID, " +
//		 		" pr.Rating as Relavance " +
//		 		" from Products p " +
//		 		" left join ProductReview pr " +
//		 		" 	on pr.ProductID = p.ProductID " +
//		 		//" where  contains(pr.Description, '%"+ searchStr +"%') or " +
//		 		"where FREETEXT(pr.Description, '%"+ searchStr +"%');";
//		 rset = statment.executeQuery(queryString);
//		 while(rset.next()){
//			 	Product p = new Product();
//				p.Description = rset.getString("Description");
//				p.Name = rset.getString("Name");
//				p.InStock = rset.getInt("InStock");
//				p.Price = rset.getDouble("Price");
//				p.ProductID = rset.getInt("ProductID");
//				p.Relavance = rset.getDouble("Relavance");
//				vProduct.add(p);
//		 }
//		 	prodArr = new Product[vProduct.size()];
//		 	vProduct.toArray(prodArr);
//		 return  prodArr;
//	}
//
// 
// public Order[] getCustomerOrders(Customer cust) throws SQLException{
//	 Order ordArr[];
//	 Vector<Order> vOrder = new Vector<Order>();
//	 
//	 Statement statment = Conn.createStatement();
//	 String queryString;
//	 ResultSet rset;
//
//	 queryString = "SELECT o.OrderID, " +
//	 "c.CustomerID, " +
//	 "c.FirstName + ', ' + c.LastName as Name, " +
//	 "c.emailAddress, " +
//	 "o.OrderDate, " +
//	 "(select StatusDescription from OrderStatus where StatusID = o.StatusID) as \"Status\", " +
//	 "sum((oi.ItemPrice - oi.DiscountAmount) * oi.Quantity) as TotalCost, " +
//	 "(select  CONCAT(Line1, ' ',  City, ', ', State,', ', ZipCode) from Addresses where AddressID = o.BillingAddressID) as BillingAddress, " +
//	 "(select  line2 from Addresses where AddressID = o.BillingAddressID ) as BillingInfo, " +
//	 "(select  concat(Line1, ' ', City, ', ', State, ', ', ZipCode) from Addresses where AddressID = o.ShipAddressID ) as ShippingAddress " +
//	 "FROM Customers c " +
//	 "JOIN Orders o " +
//	 "	on o.CustomerID = c.CustomerID " +
//	 "JOIN OrderItems oi " +
//	 "	on oi.OrderID = o.OrderID " +
//	 " where c.customerid = '" + cust.CustomerID + "' " +
//	 "GROUP BY o.OrderID, c.CustomerID, c.FirstName, c.LastName, c.emailaddress, o.OrderDate, o.StatusID, o.BillingAddressID, o.ShipAddressID;";
//	 rset = statment.executeQuery(queryString);
//	 while(rset.next()){
//		 	Order o = new Order();
//			o.OrderID = rset.getInt("OrderId");
//			o.Customer = new Customer();
//			o.Customer.CustomerID = rset.getInt("customerid");
//			o.Customer.Name = rset.getString("name");
//			o.Customer.Email = rset.getString("emailAddress");
//			o.OrderDate = rset.getDate("OrderDate");
//			o.Status = rset.getString("Status");
//			o.TotalCost = rset.getDouble("TotalCost");
//			o.BillingAddress = rset.getString("billingaddress");
//			o.BillingInfo	 = rset.getString("billinginfo");
//			o.ShippingAddress= rset.getString("shippingAddress");
//			vOrder.add(o);
//	 }
//	 ordArr = new Order[vOrder.size()];
//	 vOrder.toArray(ordArr);
//	 return ordArr;	 
// }
}

