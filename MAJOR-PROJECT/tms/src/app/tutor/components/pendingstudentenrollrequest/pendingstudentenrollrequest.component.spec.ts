import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingstudentenrollrequestComponent } from './pendingstudentenrollrequest.component';

describe('PendingstudentenrollrequestComponent', () => {
  let component: PendingstudentenrollrequestComponent;
  let fixture: ComponentFixture<PendingstudentenrollrequestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PendingstudentenrollrequestComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingstudentenrollrequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
