import { JwtInterceptor } from './service/jwt.interceptor';
import { NavComponent } from './nav/nav.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CompanyComponent } from './company/company.component';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { BsDropdownModule, PaginationModule, BsDatepickerModule } from "ngx-bootstrap";
import { BussinesPartnerComponent } from './bussines-partner/bussines-partner.component';
import { BussinesYearComponent } from './bussines-year/bussines-year.component';
import { UnitComponent } from './unit/unit.component';
import { ProductComponent } from './product/product.component';
import { DocumentComponent } from './document/document.component';
import { DocumentItemComponent } from './document/document-item/document-item.component';
import { ProductCardComponent } from './product-card/product-card.component';
import { ProductCardDetailComponent } from './product-card/product-card-detail/product-card-detail.component';
import { AnalyticsComponent } from './product-card/analytics/analytics.component';
import { WarehouseComponent } from './warehouse/warehouse.component';
import { ReportComponent } from './report/report.component';
import { LoginComponent } from './login/login.component';
import { ShoppingCartComponent } from './shopping-cart/shopping-cart.component';
import { ProductGroupComponent } from './product-group/product-group.component';
import { InventoryComponent } from './inventory/inventory.component';
import { InventoryItemComponent } from './inventory/inventory-item/inventory-item.component';

@NgModule({
  declarations: [
    AppComponent,
    CompanyComponent,
    NavComponent,
    BussinesPartnerComponent,
    BussinesYearComponent,
    UnitComponent,
    ProductComponent,
    DocumentComponent,
    DocumentItemComponent,
    ProductCardComponent,
    ProductCardDetailComponent,
    AnalyticsComponent,
    WarehouseComponent,
    ReportComponent,
    LoginComponent,
    ShoppingCartComponent,
    ProductGroupComponent,
    InventoryComponent,
    InventoryItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BsDropdownModule.forRoot(),
    PaginationModule.forRoot(),
    BsDatepickerModule.forRoot(),
    
  ],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule { }
