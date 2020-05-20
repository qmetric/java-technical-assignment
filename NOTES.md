# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

I have assumed that the same discountSchemes can be applied to any product type (Countable and Weighted),
as the price is per item or per Kg. For WeightedProducts, BuyOneGetOne means that you can get
product if weight 2 kg, for price of 1 kg. 
Similarly, `Buy one kilo of vegetables for half price` Just means that 50% discount is applied,
which makes sense for both types of products.

TODO:
- Implement rest of the discount schemes
- Think about concurrency handling if required.