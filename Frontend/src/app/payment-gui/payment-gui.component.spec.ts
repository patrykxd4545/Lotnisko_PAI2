

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PaymentGuiComponent } from './payment-gui.component';

describe('PaymentGuiComponent', () => {
  let component: PaymentGuiComponent;
  let fixture: ComponentFixture<PaymentGuiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PaymentGuiComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PaymentGuiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
