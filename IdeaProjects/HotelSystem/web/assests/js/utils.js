	$(function () {
            // инициализация datetimepicker7 и datetimepicker8
            $("#datetimepicker1").datetimepicker({
                format: 'DD.MM.YYYY'
            });
            $('#datetimepicker1').data("DateTimePicker").minDate(moment('23.07.2018','DD.MM.YYYY'));

            $("#datetimepicker2").datetimepicker({
                format: 'DD.MM.YYYY',
                useCurrent: false

            });

            $("#datetimepicker1").on("dp.change", function (e) {
                $('#datetimepicker2').data("DateTimePicker").minDate(e.date);
            });
            $("#datetimepicker2").on("dp.change", function (e) {
                $('#datetimepicker1').data("DateTimePicker").maxDate(e.date);
            });
        });
        $(function () {
            // инициализация datetimepicker7 и datetimepicker8
            $("#datetimepicker7").datetimepicker({
                format: 'DD.MM.YYYY'
            });
            $('#datetimepicker7').data("DateTimePicker").minDate(moment('23.07.2018','DD.MM.YYYY'));

            $("#datetimepicker8").datetimepicker({
                format: 'DD.MM.YYYY',
                useCurrent: false

            });

            $("#datetimepicker7").on("dp.change", function (e) {
                $('#datetimepicker8').data("DateTimePicker").minDate(e.date);
            });
            $("#datetimepicker8").on("dp.change", function (e) {
                $('#datetimepicker7').data("DateTimePicker").maxDate(e.date);
            });
        });