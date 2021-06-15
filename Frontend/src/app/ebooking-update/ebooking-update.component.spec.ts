import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EbookingUpdateComponent } from './ebooking-update.component';

describe('EbookingUpdateComponent', () => {
  let component: EbookingUpdateComponent;
  let fixture: ComponentFixture<EbookingUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EbookingUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EbookingUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
