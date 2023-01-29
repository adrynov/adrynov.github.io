import { Component, OnInit } from "@angular/core";
import { ModalController, NavParams, ViewController } from "ionic-angular";

/**
 * Simple Modal showing information about the project.
 */
@Component({
  selector: "about-dialog",
  templateUrl: "about.dialog.html",
})
export class AboutDialog implements OnInit {
  constructor(public viewCtrl: ViewController) {}

  ngOnInit() {}

  closeModal() {
    this.viewCtrl.dismiss();
  }
}
