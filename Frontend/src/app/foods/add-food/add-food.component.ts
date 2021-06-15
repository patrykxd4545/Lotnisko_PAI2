import {Component, Input, OnInit, EventEmitter, Output} from '@angular/core';
import {Food} from '../../model/food';
import {UserService} from '../../_services/user.service';
import {ActivatedRoute, Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-add-food',
  templateUrl: './add-food.component.html',
  styleUrls: ['./add-food.component.css']
})
export class AddFoodComponent implements OnInit {

  @Input()
  food: Food;

  @Output()
  foodAddedEvent = new EventEmitter();
  private selectedFile;
  imgURL: any;
  constructor(private userService: UserService,
              private activedRoute: ActivatedRoute,
              private router: Router,
              private http: HttpClient) { }

  ngOnInit() {
  }

  public onFileChanged(event) {
    console.log(event);
    this.selectedFile = event.target.files[0];

    let reader = new FileReader();
    reader.readAsDataURL(event.target.files[0]);
    reader.onload = (event2) => {
      this.imgURL = reader.result;
    };

  }

  saveFood() {
    if (this.food.id == null) {
      const uploadData = new FormData();
      uploadData.append('imageFile', this.selectedFile, this.selectedFile.name);
      this.selectedFile.imageName = this.selectedFile.name;

      this.http.post('http://localhost:8080/api/upload', uploadData, { observe: 'response' })
        .subscribe((response) => {
            if (response.status === 200) {
              this.userService.addFood(this.food).subscribe(
                (food) => {
                  this.foodAddedEvent.emit();
                  this.router.navigate(['user', 'foods']);
                }
              );
              console.log('Image uploaded successfully');
            } else {
              console.log('Image not uploaded successfully');
            }
          }
        );
    }else {
      this.userService.updateFood(this.food).subscribe(
        (food) => {
          this.foodAddedEvent.emit();
          this.router.navigate(['user', 'foods']);
        }
      );
    }
  }
}
