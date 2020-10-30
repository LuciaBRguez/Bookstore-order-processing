### Bookstore-order-processing

#### Description:
Application that simulates the order processing in a bookstore.
This application is developed by using Mule.

#### Requirements:
- Data entries can be given through one or more CSVs. The CSV contains:
    * First row: NIF headers, Client name, Request financing and / n
    * Second row: NIF data, Client name, Request financing and / n
    * Third row: ISBN headers, Quantity
    * Fourth row and following: ISBN data, Quantity.
- The stock is checked.
- The available order is processed and an invoice is issued if financing is requested.
- If financing is requested, a credit granting notification letter is processed and generated.
- The purchase is notified by mail.
