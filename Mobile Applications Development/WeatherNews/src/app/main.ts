import { ModuleWithProviders } from "@angular/core";
import { platformBrowserDynamic } from "@angular/platform-browser-dynamic";
import { StorageConfig } from "@ionic/storage";

import { AppModule } from "./app.module";

platformBrowserDynamic().bootstrapModule(AppModule);

// export declare class IonicStorageModule {
//   static forRoot(storageConfig?: StorageConfig): ModuleWithProviders;
// }
