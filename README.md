# myShoppingCart
A shopping Cart designed using servlets

RKART

Hello, Welcome to RKART.
I have divided the source folder into 4 packages.
1.	Model  – This contains the Store Inventory (Database) which is responsible for storing Products and displaying the products based on key (similar to queries/procedures) – (Class name -StoreInventory.java)
2.	Product Categories – This contains all the product categories present in the inventory (Class names - Books, Computers, Music). These are also views but extend from Store.
3.	Helpers – This contains all the helper classes to drive the application
a.	UtilityNavigator – Contains static methods to return commonly used Strings in the project.
b.	OrderedProduct – Contains properties and methods associated with an ordered product.
c.	Products – Contains properties and methods (getters and setters) for all the products.
d.	ShoppingCartController – Contains methods to control the shopping cart, deals with adding/removing the ordered products.

4.	Views – This contains all the servlets which are responsible for UI and also requesting/posting data. Session is created for the user to maintain his state while he is shopping at RKART.
a.	Store – This displays home page, other product category pages.
b.	AddCartView – Session gets created for the user when he starts adding items to his cart. Displays the recent items added to the user cart.
c.	ViewCart – Displays user cart summary with total bill amount. Also allows user to remove items from the cart.

Let us see Product class – This Contains id, productCategory, product description and Cost of the product. We have getters and setters also.
Let us see the model for our store –
StoreInventory.java – 
Products Array stores all the Product objects.
We have 2 methods which return Products based on category and ID respectively.

Now let us see ProductCategories –
Books,Computers and Music – All extend from store as they all have identical html except the data being populated. We will use getProductByCategory() method of Store Inventory class to get the products specific to the category.

HelperClasses – ShoppingCartController  - an object of this class is created and added to the user session object when the user adds items to the cart. This helper class uses OrderedProduct Class and maintains the state of the orderedproducts in the cart during the user session.
Add/remove orderedProducts are synchronized methods so that at a given point of time only 1 thread can access the resource/object.
Similarly I have used synchronized blocks in the servlets for the same purpose.

Now let us see the servlets –
Store - 
This is the Home page, just to welcome the users.
Mainly this contains the pages for product categories. Using the form and post method, the checked checkbox id (which is the product id associated) is passed to addCartView.

AddCartView – This is the main servlet where we will be creating a user session if he has added some items. If the user is new User, a new session is created, if not we will use the previous session object.
I have restricted the session Inactive interval to be 15min. (not manadatory though)
Using the checked boxes, we make a list of items being selected and display in the addCartView page

ViewCart – This is the cart summary page where we will get all ordered items using the session created through ShoppingCartController object. We use the method getItemsOrdered method in ShoppingCartController class to get all the items added in the current session.
If multiple items having same id are added, the quantity is increased accordingly.
The action column allows to remove an item once. For example if the quantity is 1, the item is removed from the list. But if the item has a quantity of 2, one item is removed and there will be another item.
I have used Cart.css for styling RKART (Some styles are taken from w3Schools)

Thank you

