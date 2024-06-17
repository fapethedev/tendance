$(document).ready(function(){
    
    (function($) {
        "use strict";

    
    jQuery.validator.addMethod('answercheck', function (value, element) {
        return this.optional(element) || /^\bcat\b$/.test(value)
    }, "type the correct answer -_-");

    // validate contactForm form
    $(function() {
        $('#contactForm').validate({
            rules: {
                name: {
                    required: true,
                    minlength: 2
                },
                subject: {
                    required: true,
                    minlength: 4
                },
                number: {
                    required: true,
                    minlength: 5
                },
                email: {
                    required: true,
                    email: true
                },
                message: {
                    required: true,
                    minlength: 20
                }
            },
            messages: {
                name: {
                    required: "Veuillez mettre votre nom",
                    minlength: "Le nom doit comporter plus de 2 caractères"
                },
                subject: {
                    required: "Il y a bien un sujet dont vous voulez nous parlez n'es-ce-pas?",
                    minlength: "Le sujet doit comporter plus de deux caractères"
                },
                number: {
                    required: "Veuillez entrez votre numéro",
                    minlength: "Le numéro doit contenir minimum 5 chiffres"
                },
                email: {
                    required: "Veuillez spécifier votre email"
                },
                message: {
                    required: "Il faut bien écrire un message",
                    minlength: "Dites-nous en plus"
                }
            }
        })
    })
        
 })(jQuery)
})