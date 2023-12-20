import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CouseListComponent } from './couse-list.component';

describe('CouseListComponent', () => {
  let component: CouseListComponent;
  let fixture: ComponentFixture<CouseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CouseListComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CouseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
