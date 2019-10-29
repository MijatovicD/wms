import { UnitService } from './../../service/unit.service';
import { ProductGroupService } from './../../service/productGroup.service';
import { DocumentItemService } from './../../service/documentItemService.service';
import { DocumentService } from './../../service/document.service';
import { ProductCardService } from './../../service/productCard.service';
import { WarehouseSerice } from './../../service/warehouse.service';
import { ProductService } from './../../service/product.service';
import { PartnerService } from './../../service/partner.service';
import { Component, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-document-item',
  templateUrl: './document-item.component.html',
  styleUrls: ['./document-item.component.scss']
})
export class DocumentItemComponent implements OnInit {

  dodavanje;
  dokument = {
    id: null,
    type: null,
    createDate: new Date(),
    status: null,
    businessPartner: { name: null },
    businessYear: { id: 5 , year:2019},
    warehouse: { name: null }
  };
  warehouses;
  partners;
  productList;
  unitList;
  groupList;
  productSelected = {
    id: null,
    product: { name: null },
    quantity: null,
    price: null,
    value: null
  };
  newProduct = {
    id: null,
    name: null,
    quantity: null,
    price: null,
    value: null,
    group: null,
    unit: null
  }
  produt = {
    id: null,
    name: null,
    quantity: null,
    price: null,
    productGroupDTO: {id:null},
    measurementUnitDTO: {id:null}
  }
  privremenaListaRobe = [];
  name;
  quantity;
  price;
  errorMsg;
  errorModal;
  item = {
    price: null,
    quantity: null,
    value: null,
    document: null,
    product: {id:null}
  };
  status;
  primka = true;

  @ViewChild("selectType") selectType = {
    nativeElement: { value: null }
  };

  @ViewChild("selectWarehouse") selectWarehouse = {
    nativeElement: { value: null }
  };

  @ViewChild("selectBusinessPartner") selectBusinessPartner = {
    nativeElement: { value: null }
  };

  @ViewChild("selectProduct") selectProduct = {
    nativeElement: { value: null }
  };
  @ViewChild("selectGroup") selectGroup = {
    nativeElement: { value: null }
  };
  @ViewChild("selectUnit") selectUnit = {
    nativeElement: { value: null }
  };
  constructor(
    private route: ActivatedRoute,
    private documentService: DocumentService,
    private partnerService: PartnerService,
    private warehouseService: WarehouseSerice,
    private itemService: DocumentItemService,
    private productCardService: ProductCardService,
    private router: Router,
    private productService: ProductService,
    private groupSerice: ProductGroupService,
    private unitSerice: UnitService
  ) {}

  ngOnInit() {
    if (this.route.snapshot.url[1].path == "add") {
      this.dodavanje = true;
    } else {
      this.dodavanje = false;
      this.documentService
        .getDokument(this.route.snapshot.url[1].path)
        .subscribe(res => {
          console.log(res);
          this.dokument = res;
          if (res.status == "Formiranje") {
            this.status = "Proknjizi";
          }
          if (res.status == "Proknjizen") {
            this.status = "Storniraj";
          }
        });
      this.itemService
        .getItems(this.route.snapshot.url[1].path)
        .subscribe(res => {
          this.privremenaListaRobe = res.map(r => {
            r.name = r.product.name;
            r.price = r.price;
            return r;
          });
        });
    }

    this.warehouseService.getAll().subscribe(res => {
      this.warehouses = res;
    });
    this.partnerService.getAll().subscribe(res => {
      this.partners = res;
    });

    this.groupSerice.findAll().subscribe(res =>{
        this.groupList = res;
        console.log(this.groupList);
    })

    this.unitSerice.getAll().subscribe(res =>{
        this.unitList = res;
        console.log(this.unitList);
    });
  }

  productListUcitavanje() {
    this.dokument.warehouse = this.warehouses.filter(
      w => w.name === this.selectWarehouse.nativeElement.value
    )[0];

    if (this.selectType.nativeElement.value == "Primka") {
      this.productService.getAll().subscribe(res => {
        this.productList = res;
      });
    } else {
      this.primka = false;
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
  }

  dodajNaListu() {
    if (this.quantity == "" || this.quantity > 0) {
      this.productSelected = this.productList.filter(
        r => r.name === this.selectProduct.nativeElement.value
      )[0];
      console.log(this.productSelected);
      if (this.primka) {
        this.productSelected.price = this.price;
      }
      let postojeca = false;

      this.privremenaListaRobe = this.privremenaListaRobe.map(r => {
        if (r.name == this.productSelected["name"]) {
          postojeca = true;
          r.quantity = parseInt(r.quantity, 10) + parseInt(this.quantity, 10);
          r.price = parseInt(r.price, 10) + parseInt(this.price, 10);
        }
        return r;
      });
      if (!postojeca) {
        this.productSelected.quantity = this.quantity;
        this.privremenaListaRobe.push(this.productSelected);
      }
    } else {
      this.errorModal = "Pogresan unos kolicine";
    }
  }

  dodajNaListuNovProizvod() {
    if (this.quantity == "" || this.quantity > 0) {
     
      let postojeca = false;

      this.privremenaListaRobe = this.privremenaListaRobe.map(r => {
        if (r.name == this.name) {
          postojeca = true;
          // r.name = this.name;
          r.quantity = parseInt(r.quantity, 10) + parseInt(this.quantity, 10);
          r.price = parseInt(r.price, 10) + parseInt(this.price, 10);
        }
        return r;
      });
        this.newProduct.name = this.name;
        this.newProduct.quantity = this.quantity;
        this.newProduct.price = this.price;
        this.privremenaListaRobe.push(this.newProduct);
        console.log(this.selectGroup.nativeElement.value);
        this.privremenaListaRobe.map(p =>{
            this.produt.id = p.id;
            this.produt.name = p.name;
            this.produt.productGroupDTO.id = this.selectGroup.nativeElement.value
            this.produt.measurementUnitDTO.id = this.selectUnit.nativeElement.value
            this.productService.add(this.produt).subscribe(producut =>{
            console.log("IDDDDDDDDDDDDDDDDDDDD" +p.id + " dsahkuhfdkjhcljkas " + this.produt.id + "rifeiesfcsdc " + producut.id);
                  this.produt.id = producut.id;
                  console.log("dsaldas " + producut);
            });
            
        });
    } else {
      this.errorModal = "Pogresan unos kolicine";
    }
  }

  validacija() {
    if (
      this.warehouses.filter(
        w => w.name === this.selectWarehouse.nativeElement.value
      )[0] == null
    ) {
      this.errorMsg = "Morate izabrati magacin.";
      return false;
    }
    if (
      this.partners.filter(
        b => b.name === this.selectBusinessPartner.nativeElement.value
      )[0] == null
    ) {
      this.errorMsg = "Morate izabrati poslovnog partnera.";
      return false;
    }
    if (this.privremenaListaRobe.length == 0) {
      this.errorMsg = "Morate dodati robu.";
      return false;
    }
    return true;
  }


  sacuvajDokument() {
    if (this.validacija()) {
      this.dokument.warehouse = this.warehouses.filter(
        w => w.name === this.selectWarehouse.nativeElement.value
      )[0];
      this.dokument.businessPartner = this.partners.filter(
        b => b.name === this.selectBusinessPartner.nativeElement.value
      )[0];
      this.dokument.type = this.selectType.nativeElement.value;
      this.dokument.status = "Formiranje";
      console.log(this.dokument);
      this.documentService.addDokument(this.dokument).subscribe(res => {
        console.log(res);
        this.dokument.id = res.id;
        this.privremenaListaRobe.map(r => {
          r.value = r.quantity * r.price;
          r.trafficDocument = this.dokument;
          this.item.price = r.price;
          this.item.quantity = r.quantity;
          this.item.document = this.dokument;
          this.item.product.id = this.produt.id;
          this.item.value = r.value;
          console.log(this.item);
          this.itemService.saveItem(this.item).subscribe(res => {
            this.router.navigateByUrl("/document");
          });
        });
      });
    }
  }

  changeStatus() {
    if (this.status == "Proknjizi") {
      this.documentService.proknjizi(this.dokument).subscribe(res => {
        console.log("knjizenjeee ");
        this.router.navigateByUrl("/document");
      });
    } else {
      this.documentService.storniraj(this.dokument).subscribe(res => {
        this.router.navigateByUrl("/document");
      });
    }
  }
}
