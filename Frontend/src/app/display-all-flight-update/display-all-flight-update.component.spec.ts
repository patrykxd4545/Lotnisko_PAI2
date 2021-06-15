import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayAllFlightUpdateComponent } from './display-all-flight-update.component';

describe('DisplayAllFlightUpdateComponent', () => {
  let component: DisplayAllFlightUpdateComponent;
  let fixture: ComponentFixture<DisplayAllFlightUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayAllFlightUpdateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayAllFlightUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
