import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EbookingDetailsComponent } from './ebooking-details.component';

describe('EbookingDetailsComponent', () => {
  let component: EbookingDetailsComponent;
  let fixture: ComponentFixture<EbookingDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EbookingDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EbookingDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
