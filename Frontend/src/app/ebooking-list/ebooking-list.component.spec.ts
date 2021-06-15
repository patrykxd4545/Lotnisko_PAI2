import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EbookingListComponent } from './ebooking-list.component';

describe('EbookingListComponent', () => {
  let component: EbookingListComponent;
  let fixture: ComponentFixture<EbookingListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EbookingListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(EbookingListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
