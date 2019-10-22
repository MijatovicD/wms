import { Observable } from 'rxjs';
import { Product } from './../model/product';
import { ProductCardService } from './../service/productCard.service';
import { ItemPage } from './../model/item.page.model';
import { ProductService } from './../service/product.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { ModalModule, ModalDirective } from 'ngx-bootstrap';

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
  price;
  prodcutCard;
  id;

  constructor(
    private productService: ProductService,
    private productCardService: ProductCardService
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

}
