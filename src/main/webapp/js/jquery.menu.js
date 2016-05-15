/**
 * jQuery menu
 *
 *  操作菜单
*/(function ($) {
    $.fn.extend({
        menu: function (_subDivTag) {
            var subDivTag = _subDivTag || '.subDiv';
            var sub = $(subDivTag);
            $(document).on('click', function () {
                sub.hide();
            });
            return this.each(function () {
                var subDiv = $(this).find(subDivTag);
                $(this).on('selectstart', function () {
                    return false;
                }).on('click', function (e) {
                    if (subDiv.is(':visible')) {
                        subDiv.fadeOut(100);
                    } else {
                        $(subDivTag+':visible').fadeOut(100);
                        subDiv.fadeIn(100);
                    }
                    e.stopPropagation();
                });

            });
        }
    });
})(jQuery);