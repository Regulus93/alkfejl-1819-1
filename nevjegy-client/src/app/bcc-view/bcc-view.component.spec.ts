import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BccViewComponent } from './bcc-view.component';

describe('BccViewComponent', () => {
  let component: BccViewComponent;
  let fixture: ComponentFixture<BccViewComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BccViewComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BccViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
