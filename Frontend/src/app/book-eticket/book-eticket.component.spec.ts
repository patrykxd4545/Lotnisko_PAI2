import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BookEticketComponent } from './book-eticket.component';

describe('BookEticketComponent', () => {
  let component: BookEticketComponent;
  let fixture: ComponentFixture<BookEticketComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BookEticketComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BookEticketComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
