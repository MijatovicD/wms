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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
