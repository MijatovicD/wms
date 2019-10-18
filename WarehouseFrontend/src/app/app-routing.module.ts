import { DocumentItemComponent } from './document/document-item/document-item.component';
import { DocumentComponent } from './document/document.component';
import { ProductComponent } from './product/product.component';
import { UnitComponent } from './unit/unit.component';
import { BussinesYearComponent } from './bussines-year/bussines-year.component';
import { BussinesPartnerComponent } from './bussines-partner/bussines-partner.component';
import { CompanyComponent } from './company/company.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: "company",
    component: CompanyComponent,  
  },
  {
    path: "partner",
    component: BussinesPartnerComponent,  
  },
  {
    path: "year",
    component: BussinesYearComponent,  
  },
  {
    path: "unit",
    component: UnitComponent,  
  },
  {
    path: "product",
    component: ProductComponent,  
  },
  {
    path: "document",
    component: DocumentComponent,  
  },
  {
    path: "document/add",
    component: DocumentItemComponent,  
  },
  {
    path: "document/:id",
    component: DocumentItemComponent,  
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
