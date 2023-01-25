import SampleClass from './index';

describe('Sample', () => {
    afterEach(() => {
      jest.restoreAllMocks();
    });

    it('should work', () => {
      expect(1).toBe(1);
    })

    // describe('#constructor', () => {
    //   it('should constuct', () => {
    //     jest.spyOn(SampleClass.prototype, 'constructor');
    //     jest.spyOn(SampleClass.prototype, 'init').mockReturnValueOnce();
    //     const instance = new SampleClass('param1');
    //     expect(instance.param1).toBe('param1');
    //     expect(instance.init).toBeCalledTimes(1);
    //   });
    // });
    // describe('#init', () => {
    //   it('should init', async () => {
    //     jest.spyOn(SampleClass.prototype, 'getData').mockResolvedValueOnce();
    //     jest.spyOn(SampleClass.prototype, 'loadIframe').mockReturnValueOnce();
    //     jest.spyOn(SampleClass.prototype, 'init').mockReturnValueOnce();
    //     const instance = new SampleClass();
    //     await instance.init();
    //     expect(instance.getData).toBeCalledTimes(1);
    //     expect(instance.loadIframe).toBeCalledTimes(1);
    //   });
    // });
  
    // describe('#getData', () => {
    //   it('should fetch data', async () => {
    //     const mResponse = { json: jest.fn().mockReturnValueOnce({}) };
    //     global.fetch = jest.fn().mockResolvedValueOnce(mResponse);
    //     jest.spyOn(SampleClass.prototype, 'init').mockReturnValueOnce();
    //     const instance = new SampleClass();
    //     await instance.getData();
    //     expect(global.fetch).toBeCalledWith('https://stackoverflow.com/');
    //     expect(mResponse.json).toBeCalledTimes(1);
    //   });
    // });
  });