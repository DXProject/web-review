function showLocation(province, city, town) {

    var loc = new Location();
    var title = ['省份', '地级市', '市、县、区'];
    $.each(title, function (k, v) {
        title[k] = '<option value="">' + v + '</option>';
    })
    $('select.loc_province').append(title[0]);
    $('select.loc_city').append(title[1]);
    $('select.loc_town').append(title[2]);
    $(".loc_province,.loc_city,.loc_town").select2()
    $('select.loc_province').change(function () {
        var parent = $(this).parent();
        var locCity = parent.find('select.loc_city');
        locCity.empty();
        locCity.append(title[1]);
        loc.fillOption(locCity, '0,' + $(this).val());
        locCity.change()
    })

    $('select.loc_city').change(function () {
        var parent = $(this).parent();
        var locTown = parent.find('select.loc_town');
        locTown.empty();
        locTown.append(title[2]);
        loc.fillOption(locTown, '0,' + parent.find('select.loc_province').val() + ',' + parent.find('select.loc_city').val());
    })

    //$('#loc_town').change(function () {
    //    $('input[@name=location_id]').val($(this).val());
    //})

    if (province) {
        loc.fillOption($('select.loc_province'), '0', province);

        if (city) {
            loc.fillOption($('select.loc_city'), '0,' + province, city);

            if (town) {
                loc.fillOption($('select.loc_town'), '0,' + province + ',' + city, town);
            }
        }

    } else {
        loc.fillOption($('select.loc_province'), '0');
    }

}

$(function () {
    showLocation();
    $('#btnval').click(function () {
        alert($('#loc_province').val() + ' - ' + $('#loc_city').val() + ' - ' + $('#loc_town').val())
    })
    $('#btntext').click(function () {
        alert($('#loc_province').select2('data').text + ' - ' + $('#loc_city').select2('data').text + ' - ' + $('#loc_town').select2('data').text)
    })
})