import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BccFormComponent } from './bcc-form.component';

describe('BccFormComponent', () => {
  let component: BccFormComponent;
  let fixture: ComponentFixture<BccFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BccFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BccFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
