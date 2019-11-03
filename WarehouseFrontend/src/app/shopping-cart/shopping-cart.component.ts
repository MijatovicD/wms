import { ProductCard } from './../model/productCard';
import { ProductCardService } from './../service/productCard.service';
import { ItemPage } from './../model/item.page.model';
import { ShoppingCartItemService } from './../service/shoppingCartItem.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-shopping-cart',
  templateUrl: './shopping-cart.component.html',
  styleUrls: ['./shopping-cart.component.scss']
})
export class ShoppingCartComponent implements OnInit {

  all;
  currentPage: number;
  itemsPerPage: number;
  itemPage: ItemPage;
  p:ProductCard;
  quantity;
  price;

  constructor(
    private shoppingCartItemService: ShoppingCartItemService,
    private productCartService: ProductCardService
  ) { }

  ngOnInit() {
    let user = JSON.parse(localStorage.getItem("userInfo")).username;

    this.shoppingCartItemService.findByUserId(user).subscribe(u =>{
        console.log(u);
        this.all = u;
        for(var i in this.all){
          console.log("FAsdas");
          console.log(i);
          this.quantity = u[i].quantity;
        }
    });
  }

  downloadReport(){
    let user = JSON.parse(localStorage.getItem("userInfo")).username;
  }

  editProduct(id){
    this.productCartService.findByProductId(id).subscribe((c: ProductCard) =>{
        console.log(c);
        this.p = c;
        console.log(this.p.price);
    });
  }
}
