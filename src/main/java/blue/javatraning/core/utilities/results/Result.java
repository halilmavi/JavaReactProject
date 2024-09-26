package blue.javatraning.core.utilities.results;

/*
    Bu yapı, özellikle servis katmanlarında işlemlerin sonuçlarını ve dönen verileri yönetmek için kullanışlıdır.
    İşlemin başarılı mı, başarısız mı olduğunu ve dönen veriyi tek bir sınıf yapısı içerisinde taşımayı sağlar.
    Result: Genel işlem sonucunu ve mesajı tutar.
    DataResult<T>: Hem işlem sonucunu hem de dönen veriyi tutar.
    SuccessDataResult<T>: İşlem başarılıysa ve veri döndürüyorsa kullanılır.
    ErrorDataResult<T>: İşlem başarısızsa ve veri döndürüyorsa kullanılır.
    SuccessResult: Başarılı işlemler için genel bir sonuç döndürür.
    ErrorResult: Başarısız işlemler için genel bir sonuç döndürür.

*/

public class Result {
    private boolean success;
    private String message;

    public Result(boolean success) {
        this.success = success;
    }

    public Result(boolean success, String message) {
        this(success);
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public String getMessage() {
        return this.message;
    }

}
