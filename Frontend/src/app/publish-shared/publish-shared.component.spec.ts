import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PublishSharedComponent } from './publish-shared.component';

describe('PublishSharedComponent', () => {
  let component: PublishSharedComponent;
  let fixture: ComponentFixture<PublishSharedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PublishSharedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PublishSharedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
