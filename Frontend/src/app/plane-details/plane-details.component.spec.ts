import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PlaneDetailsComponent } from './plane-details.component';

describe('PlaneDetailsComponent', () => {
  let component: PlaneDetailsComponent;
  let fixture: ComponentFixture<PlaneDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PlaneDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PlaneDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
