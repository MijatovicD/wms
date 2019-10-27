import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { LoginComponent } from './login/login.component';
import { ReportComponent } from './report/report.component';
import { WarehouseComponent } from './warehouse/warehouse.component';
import { ProductCardComponent } from './product-card/product-card.component';
import { DocumentItemComponent } from './document/document-item/document-item.component';
import { DocumentComponent } from './document/document.component';
import { ProductComponent } from './product/product.component';
import { UnitComponent } from './unit/unit.component';
import { BussinesYearComponent } from './bussines-year/bussines-year.component';
import { BussinesPartnerComponent } from './bussines-partner/bussines-partner.component';
import { CompanyComponent } from './company/company.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ProductCardDetailComponent } from './product-card/product-card-detail/product-card-detail.component';
import { LoggedOutGuard } from "src/guards/logged-out.guard";
import { LoggedInGuard } from "src/guards/logged-in.guard";

const routes: Routes = [
  {
    path: "company",
    component: CompanyComponent, 
    canActivate: [LoggedOutGuard] 
  },
  {
    path: "partner",
    component: BussinesPartnerComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "year",
    component: BussinesYearComponent,
    canActivate: [LoggedOutGuard]  
  },
  {
    path: "unit",
    component: UnitComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "product",
    component: ProductComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "document",
    component: DocumentComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "document/add",
    component: DocumentItemComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "document/:id",
    component: DocumentItemComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "productCard",
    component: ProductCardComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "productCard/:id",
    component: ProductCardDetailComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "warehouse",
    component: WarehouseComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "report/:id",
    component: ReportComponent,  
    canActivate: [LoggedOutGuard]
  },
  {
    path: "shoppingCart",
    component: ShoppingCartComponent,  
    canActivate: [LoggedOutGuard]
  },
  { 
    path: "login", 
    component: LoginComponent,
    canActivate: [LoggedInGuard] 
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
