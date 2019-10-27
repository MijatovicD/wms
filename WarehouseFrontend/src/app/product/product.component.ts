import { ShoppingCartItem } from './../model/shoppingCartItem';
import { ProductCard } from './../model/productCard';
import { ShoppingCartItemService } from './../service/shoppingCartItem.service';
import { Observable } from 'rxjs';
import { Product } from './../model/product';
import { ProductCardService } from './../service/productCard.service';
import { ItemPage } from './../model/item.page.model';
import { ProductService } from './../service/product.service';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.scss']
})
export class ProductComponent implements OnInit {

  all:Product[];
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  productCard;
  name;
  
  price:any;
  prodcutCard;
  // id:number;
  p:ProductCard;
  quantity;
  productId:number;
  shoppingCartitem = {
    productDTO: new Object({}),
    shoppingCart: {id:1},
    userDTO: new Object({}),
    quantity: null
  };

  constructor(
    private productService: ProductService,
    private productCardService: ProductCardService,
    private cartService: ShoppingCartItemService
  ) { }

  ngOnInit() {
    this.getProductPage(0,9);
  }

  search(name: Observable<Product[]>){
    this.productService.search(name).subscribe(p =>{
      console.log(this.all);
        this.all = p;
    });
  }
  
  getProductPage(page: number, size:number) {
    this.productService.getAllPaged(page, size)
      .subscribe(page => {
        this.itemPage = page;
        this.all = page.content;
      });
  }

  pageChanged(event: any): void {
    this.currentPage = event.page;
    this.itemsPerPage = event.itemsPerPage;
    this.getProductPage(this.currentPage - 1, this.itemsPerPage);
  }


  editProduct(id){
    this.productCardService.findByProductId(id).subscribe((c: ProductCard) =>{
        console.log(c);
        this.p = c;
        console.log(this.p.price);
    });
  }

  //metoda za dodavanje robe u korpu.
  //prosledjuje se id robe koja je selektovana
  addToCart(pId){
    console.log(pId);
    this.shoppingCartitem.productDTO = pId;
    let user = JSON.parse(localStorage.getItem("userInfo")).username;
    console.log(JSON.stringify(user));
    this.shoppingCartitem.productDTO = {"id": pId};
    this.shoppingCartitem.shoppingCart;
    this.shoppingCartitem.userDTO = {"username": user};
    this.shoppingCartitem.quantity = this.quantity;

    this.cartService.add(this.shoppingCartitem).subscribe(i =>{
      alert("Successful added to shopping cart");
      console.log(i);
    },
    (error) => alert("Sorry we don't have that quantity in warehouse")
    );

  }
}
