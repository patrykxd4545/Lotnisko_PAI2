import {ComponentFixture, TestBed, waitForAsync} from '@angular/core/testing';

import { BoardCrewComponent } from './board-crew.component';

describe('BoardCrewComponent', () => {
  let component: BoardCrewComponent;
  let fixture: ComponentFixture<BoardCrewComponent>;

  beforeEach(waitForAsync(() => {
    TestBed.configureTestingModule({
      declarations: [ BoardCrewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BoardCrewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
