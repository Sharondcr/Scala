// Item class
case class Item(id: Int, name: String, price: Double, category: String)

// Pre-set list of items
val items = List(
  Item(1, "Apple", 50.00, "Fruits & Vegetables"),
  Item(2, "Banana", 20.00, "Fruits & Vegetables"),
  Item(3, "Carrot", 30.00, "Vegetables"),
  Item(4, "Milk", 40.00, "Dairy"),
  Item(5, "Bread", 25.00, "Bakery")
)

// ShoppingCart class
class ShoppingCart {
  private var cart: List[(Int, Int, Double)] = Nil

  def addItem(itemId: Int, quantity: Int): Unit = {
    val item = items.find(_.id == itemId).get
    cart = cart ::: List((itemId, quantity, item.price * quantity))
    println("Item added successfully!")
  }

  def updateItem(cartId: Int, updatedQuantity: Int): Unit = {
    cart.find(_._1 == cartId) match {
      case Some((itemId, existingQuantity, _)) =>
        val item = items.find(_.id == itemId).get
        val newQuantity = existingQuantity + updatedQuantity
        cart = cart.filterNot(_._1 == cartId) ::: List((itemId, newQuantity, item.price * newQuantity))
        println("Item updated successfully!")
      case None => println("Item not found in cart!")
    }
  }


  def removeItem(cartId: Int): Unit = {
    cart.find(_._1 == cartId) match {
      case Some(_) =>
        cart = cart.filterNot(_._1 == cartId)
        println("Item removed successfully!")
      case None => println("Item not found in cart!")
    }
  }

  def viewCart(): Unit = {
    println("Viewing cart:")
    cart.zipWithIndex.foreach { case ((itemId, quantity, price), index) =>
      val item = items.find(_.id == itemId).get
      println(s"${index + 1}. [${itemId}] ${item.name} - Quantity: ${quantity}, Price: ${price}, Category: ${item.category}")
    }
  }

  def totalPrice(withGST: Boolean = true): Double = {
    val subtotal = cart.map(_._3).sum
    val deliveryCharge = if (subtotal < 200) 30.0 else 0.0
    val gst = if (withGST) subtotal * 0.05 else 0.0
    subtotal + deliveryCharge + gst
  }
}

// PaymentGateway class
class PaymentGateway {
  def processPayment(amount: Double, paymentMethod: String): String = {
    s"Processing payment of $amount using $paymentMethod... Payment successful! Confirmation number: UST${System.currentTimeMillis()}"
  }
}

// Main application
object USTShoppingCart {
  def main(args: Array[String]): Unit = {
    val cart = new ShoppingCart
    val paymentGateway = new PaymentGateway

    println("Welcome to the UST Shopping Cart!")

    while (true) {
      println("Please choose an option:")
      println(" 1. View menu")
      println(" 2. Add item to cart")
      println(" 3. Update item in cart")
      println(" 4. Remove item from cart")
      println(" 5. View cart")
      println(" 6. Calculate total price")
      println(" 7. Make payment")
      println(" 8. Exit")

      val option = scala.io.StdIn.readInt()

      option match {
        case 1 =>
          println("Menu:")
          items.zipWithIndex.foreach { case (item, index) =>
            println(s"${index + 1}. [${item.id}] ${item.name} - Price: ${item.price}, Category: ${item.category}")
          }

        case 2 =>
          println("Enter item ID:")
          val itemId = scala.io.StdIn.readInt()
          println("Enter quantity:")
          val quantity = scala.io.StdIn.readInt()
          cart.addItem(itemId, quantity)

        case 3 =>
          println("Enter cart ID:")
          val cartId = scala.io.StdIn.readInt()
          println("Enter updated quantity:")
          val updatedQuantity = scala.io.StdIn.readInt()
          cart.updateItem(cartId, updatedQuantity)

        case 4 =>
          println("Enter cart ID:")
          val cartId = scala.io.StdIn.readInt()
          cart.removeItem(cartId)

        case 5 =>
          cart.viewCart()

        case 6 =>
          val subtotal = cart.totalPrice(false)
          val deliveryCharge = if (subtotal < 200) 30.0 else 0.0
          val gst = subtotal * 0.05
          val totalPrice = subtotal + deliveryCharge + gst
          println(s"Subtotal: ₹$subtotal")
          println(s"Deliver Charge: ₹$deliveryCharge")
          println(s"GST: ₹$gst")
          println(s"Amount Payable: ₹$totalPrice")

        case 7 =>
          println("Choose a payment method (Credit Card/Debit Card/UPI):")
          val paymentMethod = scala.io.StdIn.readLine()
          val amount = cart.totalPrice(false) + (if (cart.totalPrice(false) < 200) 30.0 else 0.0) + (cart.totalPrice(false) * 0.05)
          println(paymentGateway.processPayment(amount, paymentMethod))
          println("Exiting the application. Goodbye!")
          System.exit(0)

        case 8 =>
          println("Exiting the application. Goodbye!")
          System.exit(0)

        case _ =>
          println("Invalid option. Please try again.")
      }
    }
  }
}