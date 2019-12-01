import { InventoryItemService } from './../../service/inventoryItemService';
import { InventoryService } from './../../service/inventory.service';
import { CommisionService } from './../../service/commission.service';
import { ProductCardService } from './../../service/productCard.service';
import { ActivatedRoute, Router } from '@angular/router';
import { WarehouseSerice } from './../../service/warehouse.service';
import { Component, OnInit, ViewChild } from '@angular/core';

@Component({
  selector: 'app-inventory-item',
  templateUrl: './inventory-item.component.html',
  styleUrls: ['./inventory-item.component.scss']
})
export class InventoryItemComponent implements OnInit {

  dodavanje;
  warehouses;
  commissionsList;
  dokument = {
    id: null,
    createDate: new Date(),
    status: null,
    businessYear: { id: 5 , year:2019},
    warehouse: { name: null }
  };
  productList;
  privremenaListaKomisije = [];
  privremenaListaRobe = [];
  commissionSelected = {
    id: null,
    name: null
  };
  name;
  newCommission = {
    id:null,
    name:null
  }
  quantity;
  productSelected = {
    id: null,
    product: { name: null },
    quantity: null,
    price: null,
    value: null
  };
  item = {
    quantity: null,
    inventoryDocumentDTO: null,
    productDTO: {id:null}
  };
  commission = {
    inventoryDocument: null
  };


  @ViewChild("selectWarehouse") selectWarehouse = {
    nativeElement: { value: null }
  };
  @ViewChild("commissionSelect") selectCommission = {
    nativeElement: { value: null }
  };
  @ViewChild("selectProduct") selectProduct = {
    nativeElement: { value: null }
  }

  constructor( private route: ActivatedRoute,
    private router: Router,
    private warehosueService: WarehouseSerice,
    private productCardService: ProductCardService,
    private commisionService: CommisionService,
    private inventoryService: InventoryService,
    private inventoryItemSerice: InventoryItemService) { }

  ngOnInit() {
    if (this.route.snapshot.url[1].path == "add") {
      this.dodavanje = true;
      
    }
   
    this.warehosueService.getAll().subscribe(res => {
      this.warehouses = res;
    });

    this.commisionService.getAll().subscribe(res =>{
        this.commissionsList = res;
    });
  }


  productListUcitavanje(){
    this.dokument.warehouse = this.warehouses.filter(
      w => w.name === this.selectWarehouse.nativeElement.value
    )[0];

    this.productCardService
    .getCardsByWarehouse(this.dokument.warehouse["id"])
    .subscribe(res => {
      this.productList = res.map(r => {
        r.product;
        r.product.price = r.price;
        return r.product;
      });
    });
  }

  listKomisije(){
      this.commissionSelected = this.commissionsList.filter(
        c => c.name === this.selectCommission.nativeElement.value
      )[0];
     
      let postojeca = false;

      this.privremenaListaKomisije = this.privremenaListaKomisije.map(c => {
        if (c.name == this.commissionSelected["name"]) {
          postojeca = true;
        }
        return c;
      });
        this.privremenaListaKomisije.push(this.commissionSelected);
  }

  dodajNaListu(){
    if (this.quantity == "" || this.quantity > 0) {
      this.productSelected = this.productList.filter(
        r => r.name === this.selectProduct.nativeElement.value
      )[0];
     
      let postojeca = false;

      this.privremenaListaRobe = this.privremenaListaRobe.map(r => {
        if (r.name == this.productSelected["name"]) {
          postojeca = true;
          r.quantity = parseInt(r.quantity, 10) + parseInt(this.quantity, 10);
        }
        return r;
      });
      if (!postojeca) {
        this.productSelected.quantity = this.quantity;
        this.privremenaListaRobe.push(this.productSelected);
      }
    }
  }

  saveDocument(){
    this.dokument.warehouse = this.warehouses.filter(
      w => w.name === this.selectWarehouse.nativeElement.value
    )[0];
    this.dokument.status = "Formiranje";
    console.log(this.dokument); 
    this.inventoryService.addDokument(this.dokument).subscribe(res =>{
      this.dokument.id = res.id;

      this.commisionService.updateByDocument(this.dokument.id).subscribe(res =>{
        console.log(res);
      });

      this.privremenaListaRobe.map(r => {
        r.trafficDocument = this.dokument;
        this.item.quantity = r.quantity;
        this.item.inventoryDocumentDTO = this.dokument;
        this.item.productDTO.id = r.id;
        this.commission.inventoryDocument = this.dokument.id;
        console.log(this.item);
        this.inventoryItemSerice.saveItem(this.item).subscribe(res => {
          this.router.navigateByUrl("/inventory");
        });
      });
     
    });
  }
}
