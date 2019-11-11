import { CommisionService } from './../../service/commission.service';
import { ProductCardService } from './../../service/productCard.service';
import { ActivatedRoute } from '@angular/router';
import { WarehouseSerice } from './../../service/warehouse.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inventory-item',
  templateUrl: './inventory-item.component.html',
  styleUrls: ['./inventory-item.component.scss']
})
export class InventoryItemComponent implements OnInit {

  dodavanje;
  warehouses;
  commissions;

  constructor( private route: ActivatedRoute,
    private warehosueService: WarehouseSerice,
    private productCardService: ProductCardService,
    private commisionService: CommisionService) { }

  ngOnInit() {
    if (this.route.snapshot.url[1].path == "add") {
      this.dodavanje = true;
      
    }
   
    this.warehosueService.getAll().subscribe(res => {
      this.warehouses = res;
    });

    this.commisionService.getAll().subscribe(res =>{
        this.commissions = res;
    });
  }

}
