
"use strict";
angular.module("vidulumApp").directive('uiVideo', function () {
    var vp; 
    var videoId = Math.floor((Math.random() * 1000) + 100); 

    return {
        template: '<div class="video">' +
            '<video  width="1000" height="500"  controls preload="auto" >' +
                  '<source  ng-src="{{ videosrc }}"  type="video/mp4"> '+    
                'Your browser does not support the video tag. ' +
            '</video></div>',
        link: function (scope, element, attrs) {
        }
    };
});

