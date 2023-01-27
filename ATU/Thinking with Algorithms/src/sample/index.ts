class SampleClass {
    constructor(public param1: string) {
      this.param1 = param1;
      this.init();
    }
    async init() {
      await this.getData();
      this.loadIframe();
    }
    async getData() {
      const url = 'https://google.com/';
      const response = await fetch(url);
      const data = response.json();
      // this.param2 = data;
    }
    
    loadIframe() {
      console.log('loading iFrame')
    }
  }
  
  export default SampleClass;