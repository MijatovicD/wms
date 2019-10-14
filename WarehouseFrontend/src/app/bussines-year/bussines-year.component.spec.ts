import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BussinesYearComponent } from './bussines-year.component';

describe('BussinesYearComponent', () => {
  let component: BussinesYearComponent;
  let fixture: ComponentFixture<BussinesYearComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BussinesYearComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BussinesYearComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
