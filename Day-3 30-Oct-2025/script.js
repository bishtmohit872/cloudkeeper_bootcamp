var prods= []

function Product(image, name, price, category) {
    this.image = image
    this.name = name;
    this.price = price;
    this.category = category;

    this.getDetails = () => {
        return {Image:image,Name:name, Price:price, Category:category}
    }
}

Product.prototype.getDiscountedPrice = function (percent) {
    var discount = (this.price * percent) / 100;
    return this.price - discount;
};



(function load() {

    var p1 = new Product("https://rukminim2.flixcart.com/image/480/640/xif0q/shoe/7/d/4/6-195-40-asteroid-black-original-imah7byzffjfevkg.jpeg?q=90", "Sneaker Shoe", "2500", "Footwear")

    var p2 = new Product("https://www.jackjones.in/cdn/shop/files/280182703_g0.jpg?v=1758709225&width=600", "T-shirt", "3000", "Fashion")

    var p3 = new Product("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcRo-AQGV_AiooayBW8HQOXvZ89Kfc6ARfTfR-Fsat-9FQdK7BuSclpKJJB0nmpcY1gqsgnIE_wBoGqAKH3fj9DreQYOhull1yFsPpdcIH0ERiH-p1N9QGzn", "SmartPhone", "25000", "Gadget")

    var p4 = new Product("https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcSMoSQoPWgl77WUzTwURyHLjY5RS5hAZ6dRcQiaaQzPdvvIFR2J8kE_kelpnjmqQx8Hi1EFdz0a5xr8FKhav3FQD0ytf5ke9RKJvhHTm3IrzO0M1WfoRfHJ93M", "Kettle", "2500", "Appliances")


    var products = [
        {
            prod1: p1.getDetails(),
            discount: p1.getDiscountedPrice(10),
        },
        {
            prod1: p2.getDetails(),
            discount: p2.getDiscountedPrice(20),
        },
        {
            prod1: p3.getDetails(),
            discount: p3.getDiscountedPrice(15),
        },
        {
            prod1: p4.getDetails(),
            discount: p4.getDiscountedPrice(30),
        },
    ]
    prods=products
})()

console.log(prods)

var cards = document.getElementById("cards")


prods.forEach((item)=>{
    var div = document.createElement("div")
    div.classList.add('card')
    
    var image = document.createElement("img")
    image.src = item.prod1.Image
    
    div.appendChild(image)

    
    var div_details = document.createElement("div")
    div_details.classList.add("details")

    var para1 = document.createElement("p")
    para1.innerText = "Name"
    var span1 = document.createElement("span")
    span1.innerText = `${item.prod1.Name}`

    para1.appendChild(span1)

    var para2 = document.createElement("p")
    para2.innerText = "Price "
    var span2 = document.createElement("span")
    span2.innerText = `${item.prod1.Price}`

    para2.appendChild(span2)

    var para3 = document.createElement("p")
    para3.innerText = "Category"
    var span3 = document.createElement("span")
    span3.innerText = `${item.prod1.Category}`

    para3.appendChild(span3)

    var para4 = document.createElement("p")
    para4.innerText = "Discount"
    var span4 = document.createElement("span")
    span4.innerText = `${item.discount}`

    para4.appendChild(span4)

    div_details.appendChild(para1)
    div_details.appendChild(para2)
    div_details.appendChild(para3)
    div_details.appendChild(para4)

    div.appendChild(div_details)  
    
    cards.appendChild(div)

    div.addEventListener("mouseover", function() {
        this.style.transform = "scale(1.05)";
        this.style.transition = "transform 0.3s";
    });

    div.addEventListener("mouseout", function() {
        this.style.transform = "scale(1)";
    });

})


var prices = []
prods.forEach((item)=>{
    prices.push(item.prod1.Price)
})


var costliest = Math.max.apply(null,prices)

var info = document.querySelector(".info")

var para = document.createElement("p")
para.innerText = `Costliest Price : ${costliest}`
para.style.padding = "8px 4px"
para.style.backgroundColor = "#dce6df"
para.style.borderRadius = '8px'

info.appendChild(para)




