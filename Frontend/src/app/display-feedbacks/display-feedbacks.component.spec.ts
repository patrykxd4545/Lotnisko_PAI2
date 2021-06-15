import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayFeedbacksComponent } from './display-feedbacks.component';

describe('DisplayFeedbacksComponent', () => {
  let component: DisplayFeedbacksComponent;
  let fixture: ComponentFixture<DisplayFeedbacksComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayFeedbacksComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayFeedbacksComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
