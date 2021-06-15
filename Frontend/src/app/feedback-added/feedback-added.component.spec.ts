import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FeedbackAddedComponent } from './feedback-added.component';

describe('FeedbackAddedComponent', () => {
  let component: FeedbackAddedComponent;
  let fixture: ComponentFixture<FeedbackAddedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ FeedbackAddedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(FeedbackAddedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
